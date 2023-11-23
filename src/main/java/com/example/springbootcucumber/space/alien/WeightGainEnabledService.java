package com.example.springbootcucumber.space.alien;

import org.springframework.stereotype.Service;

@Service
public class WeightGainEnabledService {
    private ThreadLocal<Boolean> shouldAddWeight = ThreadLocal.withInitial(() -> false);

    public void enableWeightGain() {
        shouldAddWeight.set(true);
    }

    public boolean isEnabled() {
        return shouldAddWeight.get();
    }
}
