package pe.edu.upc.avi_aplicaction.securities;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private String jwtToken;

    public String getJwtToken() { return jwtToken; }

    public JwtResponse(String jwtToken) {
        super();
        this.jwtToken = jwtToken;
    }
}
