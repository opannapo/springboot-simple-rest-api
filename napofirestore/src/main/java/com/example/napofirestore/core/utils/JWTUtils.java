package com.example.napofirestore.core.utils;

import com.example.napofirestore.api.common.config.AppConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.HashMap;

@Component
public class JWTUtils {
    private AppConfig appConfig;

    public JWTUtils(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void validateToken(String jtwToken, ValidateCallback callback) {
        try {
            System.out.println("jtwToken " + jtwToken);
            Jws<Claims> claim = Jwts.parserBuilder()
                    .setSigningKey(appConfig.getJwtKey().getBytes())
                    .build()
                    .parseClaimsJws(jtwToken);

            callback.onValidateResult(claim, null);
        } catch (Exception ex) {
            ex.printStackTrace();
            callback.onValidateResult(null, ex);
        }
    }

    @SneakyThrows
    public String generateToken(int uuid) {
        Key signingKey = new SecretKeySpec(appConfig.getJwtKey().getBytes(), SignatureAlgorithm.HS256.getJcaName());

        HashMap<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        JSONObject object = new JSONObject();
        object.put("iat", (System.currentTimeMillis() / 1000));
        object.put("exp", (System.currentTimeMillis() / 1000) + (60 * 60));// 1jam 60Detik * 60Detik
        object.put("uid", uuid);

        String jws = Jwts.builder()
                .setHeader(header)
                .setPayload(object.toString())
                .signWith(signingKey)
                .compact();
        return jws;
    }


    public interface ValidateCallback {
        void onValidateResult(Jws<Claims> claims, Exception ex);
    }

}
