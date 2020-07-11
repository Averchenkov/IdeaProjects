package lab1;

public class WiredMouse extends Mouse {
    private Double lengthCable;
    private Double size;

    public Double getLengthCable() {
        return lengthCable;
    }

    public void setLengthCable(Double lengthCable) {
        this.lengthCable = lengthCable;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double volume) {
        this.size = volume;
    }

    @Override
    public String toString() {
        return "WiredMouse{" +
                " model=" + getModel() +
                ", color=" + getColor() +
                ", producer=" + getProducer() +
                ", producerCountry=" + getProducerCountry() +
                ", lengthCable=" + lengthCable +
                ", size=" + size +
                '}';
    }
}
