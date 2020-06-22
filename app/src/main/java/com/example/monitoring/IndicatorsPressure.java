package com.example.monitoring;

import java.time.LocalDateTime;

public class IndicatorsPressure {
    private int topPressure;
    private int lowerPressure;
    private int pulse;
    private boolean tachycardia;
    private LocalDateTime froze;

    public IndicatorsPressure(int topPressure, int lowerPressure, int pulse, boolean tachycardia, LocalDateTime froze) {
        this.topPressure = topPressure;
        this.lowerPressure = lowerPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.froze = froze;
    }

}
