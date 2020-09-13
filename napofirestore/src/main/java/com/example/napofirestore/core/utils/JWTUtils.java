package com.example.napofirestore.core.utils;

import com.example.napofirestore.api.common.config.AppConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

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


    public interface ValidateCallback {
        void onValidateResult(Jws<Claims> claims, Exception ex);
    }

    public interface GenerateCallback {
        void onGenerateResult(String token, Exception ex);
    }

}
