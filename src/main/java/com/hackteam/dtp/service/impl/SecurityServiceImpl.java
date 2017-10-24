package com.hackteam.dtp.service.impl;


import com.hackteam.dtp.model.User;
import com.hackteam.dtp.security.JWTToken;
import com.hackteam.dtp.service.SecurityService;
import com.hackteam.dtp.service.UserService;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.ReadOnlyJWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    UserService userService;
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();


    @Override
    public User getCurrentUser() {
        return userService.findOneByEmail(getCurrentUsersEmail());
    }

    @Override
    public String getCurrentUsersEmail() {
        JWTToken jwtToken = (JWTToken) SecurityContextHolder.getContext().getAuthentication();
        ReadOnlyJWTClaimsSet claimsSet = jwtToken.getClaims();
        return (String) claimsSet.getClaim("email");
    }

    @Override
    public String generateToken(String email, String password) {
        JWTClaimsSet claimsSet = new JWTClaimsSet();
        claimsSet.setClaim("email", email);
        claimsSet.setClaim("password", password);
//        claimsSet.setSubject(email + encoder.encode(password));

        return this.signAndSerializeJWT(claimsSet, "jfodfusdhfiaushfiqwuehfqwuhfsdhflakhewqoifhkadlkahfiqwuehlchushfiuwhuw" +
                "asddddddddddddddddddddddd" +
                "asdasdasdasdasdasdasdadas" +
                "asdasdasdasdasdqwdqdqdqsd" +
                "qsdqsdqsdqsdqdqsdqsdqdqsd");
    }


    private String signAndSerializeJWT(JWTClaimsSet claimsSet, String secret) {
        JWSSigner signer = new MACSigner(secret);
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS512), claimsSet);
        try {
            signedJWT.sign(signer);
            return signedJWT.serialize();
        } catch (JOSEException e) {
            e.printStackTrace();
            return null;
        }
    }
}
