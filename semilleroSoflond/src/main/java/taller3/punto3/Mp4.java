package taller3.punto3;

public class Mp4 extends FormatoVideo{

    public Mp4(String creador, String tipoDeVideo) {
        super(creador, tipoDeVideo);
    }
    @Override
    public void reproducirAudio() {
        System.out.println("Reproduciendo el audio del video....");
    }
}
