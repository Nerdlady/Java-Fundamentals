package com.company.TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;

public class Test {
    @Mock
    private Sensor sensorMock;

    private Alarm alarm;

    @Before
    public void inilizlize(){
        sensorMock = Mockito.mock(Sensor.class);
        alarm = new Alarm();

    }

    @org.junit.Test
    public void testLowPressureThreshold(){
        Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn(15.5);
        this.alarm.check(this.sensorMock);

        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @org.junit.Test
    public void testHighPressureThreshold(){
        Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn(35.5);
        this.alarm.check(this.sensorMock);

        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @org.junit.Test
    public void testMiddlePressureThresholdShoulReturFalse(){
        Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn(18.5);
        this.alarm.check(this.sensorMock);

        Assert.assertFalse(this.alarm.getAlarmOn());
    }

}
