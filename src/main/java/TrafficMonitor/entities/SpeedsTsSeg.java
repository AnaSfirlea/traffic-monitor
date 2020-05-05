package TrafficMonitor.entities;

import TrafficMonitor.utils.Pair;
import TrafficMonitor.utils.TODO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SpeedsTsSeg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ElementCollection
    private List<Integer> speedsList = new ArrayList<>(); //the list of speeds for a certain segment and timestamp

    private long timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "segment")
    private Segment segment;

    @OneToMany(
            mappedBy = "speedsTsSeg",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SizeAndMean> sizeAndMeanList = new ArrayList<>();

    //astea vor fi mutate in dto ???
    public int calculateMean() {
        int m=0;
        for (int speed:speedsList) {
            m+=speed;
        }
        m=m/speedsList.size();
        return m;
    }

    //astea vor fi mutate in dto ???
    public void addSpeedAndPairSizeMean(int speed) {
        speedsList.add(speed);
        sizeAndMeanList.add(this.getSizeAndMean());
    }

    @TODO
    //astea vor fi mutate in dto ???
    public SizeAndMean getSizeAndMean() {
        return new SizeAndMean();// new SizeAndMean(this.speedsList.size(),this.calculateMean(),this);
        //LINIA DE MAI SUS TREBUIE ADAUGAT IN REPO SIZE AND MEAN
    }

    @TODO
    //astea vor fi mutate in dto ???
    public SizeAndMean getMaxSizeMaxMean() {
        int maxSize = -1;
        int correctMean = -1;
        for (SizeAndMean sizeAndMean:sizeAndMeanList) {
            if(sizeAndMean.getSize()> maxSize) {
                maxSize=sizeAndMean.getSize();
                correctMean = sizeAndMean.getMean();
            }
        }
        return new SizeAndMean(); //new SizeAndMean(maxSize,correctMean,this);
        //LINIA DE MAI SUS TREBUIE ADAUGAT IN REPO SIZE AND MEAN

    }

    @TODO
    //astea vor fi mutate in dto ???
    public Pair<Integer,SizeAndMean> getMaxMarginOfErrorAndSM() {
        SizeAndMean maxSizeAndMean = this.getMaxSizeMaxMean();
        int maxMarginOfError = 0;
        SizeAndMean correspMarginSizeAndMean = null;
        for (SizeAndMean sizeAndMean:sizeAndMeanList) {

            int marginOfError = abs(sizeAndMean.getMean() - maxSizeAndMean.getMean());

            if(marginOfError > maxMarginOfError)
            {
                maxMarginOfError = marginOfError;
                correspMarginSizeAndMean = sizeAndMean;
            }
        }
        return new Pair<>(maxMarginOfError,correspMarginSizeAndMean);
    }
    @Override
    public String toString() {
        return speedsList.toString()+","+ this.timestamp + "," + this.segment;
    }
}
