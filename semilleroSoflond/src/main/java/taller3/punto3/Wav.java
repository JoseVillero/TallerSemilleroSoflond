package taller3.punto3;

public class Wav extends FormatoAudio{

    public Wav(int duracion, int tamanio, String artista, String commpositor, String generoMusical) {
        super(duracion, tamanio, artista, commpositor, generoMusical);
    }

    @Override
    public void reproducirAudio() {
        System.out.println("Reproduciendo el audio wav....");
    }
}
