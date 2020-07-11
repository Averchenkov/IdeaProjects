package lab1;

public class WirelessMouse extends Mouse {
    private Integer workTime;
    private Double weight;

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double volumeBag) {
        this.weight = volumeBag;
    }

    @Override
    public String toString() {
        return "WirelessMouse{" +
                " model=" + getModel() +
                ", color=" + getColor() +
                ", producer=" + getProducer() +
                ", producerCountry=" + getProducerCountry() +
                ", workTime=" + getWorkTime() +
                ", weight=" + getWeight() +
                '}';
    }
}

