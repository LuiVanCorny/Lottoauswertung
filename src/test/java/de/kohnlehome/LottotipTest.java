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
        lottozahlen = mock(ILottozahlen.class);
        when(lottozahlen.getLottozahlen(new Date(2020, 04, 29))).thenReturn(new int[]{1,2,8,9,10,11,12});
        when(lottozahlen.getLottozahlen(new Date(2020, 03, 28))).thenReturn(new int[]{1,2,3,4,5,8,9});
        when(lottozahlen.getLottozahlen(new Date(2018, 05, 02))).thenReturn(new int[]{8,9,10,11,12,13,14});

        lottotip = new Lottotip(lottozahlen);

    }

    @Test
    public void tippAbgeben_29_04_2020_Test(){
        int[] tipp = {1,2,3,4,5,6,7};
        Date date = new Date(2020,04,29);
        int result = lottotip.tippAbgeben(tipp, date);

        assertThat(result).isEqualTo(2);

    }

    @Test
    public void tippAbgeben_28_03_2020_Test(){
        int[] tipp = {1,2,3,4,5,6,7};
        Date date = new Date(2020, 03, 28);
        int result = lottotip.tippAbgeben(tipp, date);

        assertThat(result).isEqualTo(5);

    }

    @Test
    public void tippAbgeben_02_05_2018_Test(){
        int[] tipp = {1,2,3,4,5,6,7};
        Date date = new Date(2018, 05, 02);
        int result = lottotip.tippAbgeben(tipp, date);

        assertThat(result).isEqualTo(0);

    }
}