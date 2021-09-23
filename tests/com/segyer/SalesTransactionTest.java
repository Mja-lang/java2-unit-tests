package com.segyer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SalesTransactionTest {
    private SalesTransaction transaction;
    Random r;

    @BeforeEach
    void setUp() {
        transaction = new SalesTransaction();
        r = new Random();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTransactionId() {
        int expected = 0;
        int actual = transaction.getTransactionId();
        assertEquals(expected, actual);
    }

    @Test
    void setTransactionIdBad() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                transaction.setTransactionId(-1);
            }
        });
    }

    @Test
    void setTransactionIdGood() {
        int expected = r.nextInt(50) + 1;
        transaction.setTransactionId(expected);
        int actual = transaction.getTransactionId();
        assertEquals(expected, actual);
    }

    @Test
    void getSalesPersonID()  {
        assertEquals(SalesTransaction.DEFAULT_SALES_PERSON_ID, transaction.getSalesPersonID());
    }

    @Test
    void setSalesPersonIDPositiveGood() {
        int expected = r.nextInt(50) + 1;
        transaction.setSalesPersonID(expected);
        int actual = transaction.getSalesPersonID();
        assertEquals(expected, actual);

    }
    @Test
    void setSalesPersonIDNegativeBad() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                transaction.setSalesPersonID(-10);
            }
        });
    }
    @Test
    void getTransactionDateTime() {
        assertEquals(SalesTransaction.DEFAULT_TRANSACTION_DATE_TIME, transaction.getTransactionDateTime());
    }

    @Test
    void setTransactionDateTimeTodayGood() {
        LocalDateTime newTransactionDateTime = SalesTransaction.DEFAULT_TRANSACTION_DATE_TIME;
        transaction.setTransactionDateTime(newTransactionDateTime);
        assertEquals(SalesTransaction.DEFAULT_TRANSACTION_DATE_TIME, transaction.getTransactionDateTime());
    }
    @Test
    void setTransactionDateTimeBadFuture(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                transaction.setTransactionDateTime(SalesTransaction.DEFAULT_TRANSACTION_DATE_TIME.plusDays(1));
            }
        });

    }
    @Test
    void setTransactionDateTimeBadPast(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                transaction.setTransactionDateTime(SalesTransaction.DEFAULT_TRANSACTION_DATE_TIME.minusYears(11));
            }
        });

    }


    @Test
    void getItemId() {
        assertEquals(SalesTransaction.DEFAULT_ITEM_ID, transaction.getItemId());
    }

    @Test
    void setItemIdPositiveGood() {
        int expected = r.nextInt(50) + 1;
        transaction.setItemId(expected);
        int actual = transaction.getItemId();
        assertEquals(expected, actual);


    }

    @Test
    void setItemIdNegativeBad() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                transaction.setItemId(-1);
            }
        });
    }


    @Test
    void getUnitPrice() {
            assertEquals(SalesTransaction.DEFAULT_UNIT_PRICE, transaction.getUnitPrice());

    }


    @Test
    void setUnitPricePostitiveGood() {
        double expected = r.nextDouble() + 1;
        DecimalFormat format = new DecimalFormat("#.##");
        expected = Double.valueOf(format.format(expected));
        transaction.setUnitPrice(expected);
        double actual = transaction.getUnitPrice();
        assertEquals(expected, actual);


        }
    @Test
    void setUnitPriceNegativeBad() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                transaction.setUnitPrice(-1);
            }
        });
    }

    @Test
    void getQuantitySold() {
        assertEquals(SalesTransaction.DEFAULT_QUANTITY_SOLD, transaction.getQuantitySold());
    }



    @Test
    void setQuantitySoldPositiveGood() {
        int expected = r.nextInt(50) + 1;
        transaction.setQuantitySold(expected);
        int actual = transaction.getQuantitySold();
        assertEquals(expected, actual);


    }

    @Test
    void setQuantitySoldNegativeBad() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                transaction.setQuantitySold(-1);
            }
        });
    }

    @Test
    void compareTo() {

    }
}