package pe.edu.upc.avi_aplicaction.dtos;

public class ConjuntoDiaSemanaDTO {
    private String  nombreconjunto;
    private int totalDias;

    public String getNombreconjunto() {
        return nombreconjunto;
    }

    public void setNombreconjunto(String nombreconjunto) {
        this.nombreconjunto = nombreconjunto;
    }

    public int getTotalDias() {
        return totalDias;
    }

    public void setTotalDias(int totalDias) {
        this.totalDias = totalDias;
    }

}
