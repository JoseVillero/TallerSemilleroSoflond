package taller3.punto3;

public abstract class FormatoVideo implements Reproducible{

    private String Creador;
    private String tipoDeVideo;

    public FormatoVideo(String creador, String tipoDeVideo) {
        Creador = creador;
        this.tipoDeVideo = tipoDeVideo;
    }

}
