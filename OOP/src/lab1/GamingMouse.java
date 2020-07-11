package lab1;

public class GamingMouse extends Mouse {
    private Double dpi;
    private Integer numButtons;

    public Double getDpi() {
        return dpi;
    }

    public void setDpi(Double dpi) {
        this.dpi = dpi;
    }

    public Integer getNumButtons() {
        return numButtons;
    }

    public void setNumButtons(Integer numButtons) {
        this.numButtons = numButtons;
    }

    @Override
    public String toString() {
        return "GamingMouse{" +
                " model=" + getModel() +
                ", color=" + getColor() +
                ", producer=" + getProducer() +
                ", producerCountry=" + getProducerCountry() +
                ", dpi=" + dpi +
                ", numButtons=" + numButtons +
                '}';
    }
}
