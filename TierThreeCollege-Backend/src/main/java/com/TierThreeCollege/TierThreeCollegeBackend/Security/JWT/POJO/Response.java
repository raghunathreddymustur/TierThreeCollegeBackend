package com.TierThreeCollege.TierThreeCollegeBackend.Security.JWT.POJO;

public class Response {
   private String jwt;

    public Response(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
