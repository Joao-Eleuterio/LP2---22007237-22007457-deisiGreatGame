package pt.ulusofona.lp2.deisiGreatGame;

public class SegmentationFault extends Abismo{

    public SegmentationFault(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "Segmentation Fault";
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
