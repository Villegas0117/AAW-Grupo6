package pe.edu.upc.avi_aplicaction.dtos;

public class ConjuntoPorUsuarioDTO {
    private String  username;
    private int total_conjuntos;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotal_conjuntos() {
        return total_conjuntos;
    }

    public void setTotal_conjuntos(int total_conjuntos) {
        this.total_conjuntos = total_conjuntos;
    }

}
