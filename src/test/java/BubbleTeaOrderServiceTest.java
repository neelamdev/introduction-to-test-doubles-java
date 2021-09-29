import com.techreturners.bubbleteaordersystem.model.*;
import com.techreturners.bubbleteaordersystem.service.BubbleTeaMessenger;
import com.techreturners.bubbleteaordersystem.service.BubbleTeaOrderService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import testhelper.DummySimpleLogger;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.lang.String;
import java.util.stream.Collectors;

public class BubbleTeaOrderServiceTest {

    private DebitCard testDebitCard;
    private PaymentDetails paymentDetails;
    private DummySimpleLogger dummySimpleLogger;
    private BubbleTeaMessenger mockMessenger;
    private BubbleTeaOrderService bubbleTeaOrderService;

    @BeforeEach
    public void setup() {
        testDebitCard = new DebitCard("0123456789");
        paymentDetails = new PaymentDetails("hello kitty", "sanrio puroland", testDebitCard);
        dummySimpleLogger = new DummySimpleLogger();
        mockMessenger = mock(BubbleTeaMessenger.class);
        bubbleTeaOrderService = new BubbleTeaOrderService(dummySimpleLogger, mockMessenger);
    }


    @DisplayName("Should pass non-null enum values as method parameters")
    @ParameterizedTest
    @EnumSource(value = BubbleTeaTypeEnum.class,names = {"OolongMilkTea","JasmineMilkTea","MatchaMilkTea"})
     public void shouldCreateBubbleTeaOrderRequestWhenCreateOrderRequestIsCalled() {

       // System.out.println( Arrays.stream(BubbleTeaTypeEnum.values()).map());
        BubbleTea bubbleTea = new BubbleTea(Arrays.stream(BubbleTeaTypeEnum.values()).iterator().next(), 4.5);

            BubbleTeaRequest bubbleTeaRequest = new BubbleTeaRequest(paymentDetails, bubbleTea);


            BubbleTeaOrderRequest expectedResult = new BubbleTeaOrderRequest(
                    "hello kitty",
                    "sanrio puroland",
                    "0123456789",
                    BubbleTeaTypeEnum.OolongMilkTea

            );

            //Act
            BubbleTeaOrderRequest result = bubbleTeaOrderService.createOrderRequest(bubbleTeaRequest);

           // Assert
            assertEquals(expectedResult.getName(), result.getName());
            assertEquals(expectedResult.getAddress(), result.getAddress());
            assertEquals(expectedResult.getDebitCardDigits(), result.getDebitCardDigits());
            System.out.println("expected  " + expectedResult.getBubbleTeaType());
            System.out.println("Actual  " + result.getBubbleTeaType());
            assertEquals(expectedResult.getBubbleTeaType(), result.getBubbleTeaType());

            //Verify Mock was called with the BubbleTeaOrderRequest result object
            verify(mockMessenger).sendBubbleTeaOrderRequestEmail(result);
            verify(mockMessenger, times(1)).sendBubbleTeaOrderRequestEmail(result);

        }
    }



