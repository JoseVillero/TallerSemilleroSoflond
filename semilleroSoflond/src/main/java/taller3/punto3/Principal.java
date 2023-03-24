package taller3.punto3;

public class Principal {

    /**
     *  Para la implementacion de la solucion opte por la utilizacion de interfaz y clase abstracta
     *  un video mp4 es un formato de video que hereda de la clase abstracta FormatoVideo sus atributos
     *  un audio mp3 y wav son un formato de audio que hereda de la clase abstracta FormatoAudio sus atributos
     *  FormatoVideo y FormatoAudio implementan de la intefaz Reproducible el metodo reproducirAudio()
     *  Es decir un mp4, mp3 y wav son de tipo Reproducible por lo tanto implementan el metodo reproducirAudio()
     *  de diferentes formas cada uno.
     *  En una futura adicion de formatos de video o audio, los nuevos formatos extenderian de FormatoAudio
     *  o FormatoVideo e implementarian el metodo reproducirAudio()
     *  La ventaja al usar la interfaz Reproducible es que podemos hacer 'Reproducible' distintas cosas, no solo
     *  FormatoVideo y FormatoAudio. Si se llega a adicionar un tipo Formato3D este implementaria la interfaz y
     *  seria capaz de reproducir audio.
     */

    public static void main(String[] args) {

        FormatoVideo video1 = new Mp4("Hector Lavoe","musical");
        FormatoAudio audio1 = new Mp3(180,2000,"Cheo Feliciano", "Tite curett", "Salsa");
        FormatoAudio audio2 = new Wav(190,3000,"Joe Arroyo", "Joe Arroyo", "Joe Son");

        video1.reproducirAudio();
        audio1.reproducirAudio();
        audio2.reproducirAudio();





    }
}
