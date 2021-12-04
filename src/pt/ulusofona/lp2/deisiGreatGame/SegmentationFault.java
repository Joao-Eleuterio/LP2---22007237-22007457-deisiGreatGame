package pt.ulusofona.lp2.deisiGreatGame;

public class SegmentationFault extends Trap{

    public SegmentationFault() {
        this.titulo="Segmentation Fault";
        this.id=9;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }
    @Override
    public String getImage() {
        return "core_dump2.png";
    }

    @Override
    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
