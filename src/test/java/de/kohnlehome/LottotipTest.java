package de.kohnlehome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


public class LottotipTest {
    private ILottozahlen lottozahlen;
    private Lottotip lottotip;

    @BeforeEach
    public void init(){
        // ===== ARRANGE =====
        // Testdouble erstellen
        lottozahlen = mock(ILottozahlen.class);
        when(lottozahlen.getLottozahlen(new Date())).thenReturn(new int[]{1,2,8,9,10,11,12});
        when(lottozahlen.getLottozahlen(new Date(2020, 03, 28))).thenReturn(new int[]{1,2,3,4,5,8,9});
        when(lottozahlen.getLottozahlen(new Date(2018, 05, 02))).thenReturn(new int[]{8,9,10,11,12,13,14});

        lottotip = new Lottotip(lottozahlen);

        // Verhalten des Testdoubles definieren
        //when(myInterface.method(3)).thenReturn(7);
    }

    @Test
    public void tippAbgeben_today_Test(){
        // ===== ACT =====
        int[] tipp = {1,2,3,4,5,6,7};
        Date date = new Date();
        int result = lottotip.tippAbgeben(tipp, date);

        // ===== ASSERT =====
        // Überprüfen, ob Methode richtigen Wert zurückgibt
        assertThat(result).isEqualTo(2);

    }

    @Test
    public void tippAbgeben_28_03_2020_Test(){
        // ===== ACT =====
        int[] tipp = {1,2,3,4,5,6,7};
        Date date = new Date(2020, 03, 28);
        int result = lottotip.tippAbgeben(tipp, date);

        // ===== ASSERT =====
        // Überprüfen, ob Methode richtigen Wert zurückgibt
        assertThat(result).isEqualTo(5);

    }

    @Test
    public void tippAbgeben_02_05_2018_Test(){
        // ===== ACT =====
        int[] tipp = {1,2,3,4,5,6,7};
        Date date = new Date(2018, 05, 02);
        int result = lottotip.tippAbgeben(tipp, date);

        // ===== ASSERT =====
        // Überprüfen, ob Methode richtigen Wert zurückgibt
        assertThat(result).isEqualTo(0);

    }
}