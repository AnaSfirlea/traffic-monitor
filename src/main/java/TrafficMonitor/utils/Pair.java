package TrafficMonitor.utils;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pair<K,T> {
    private K firstField;
    private T secondField;
}
