package com.segyer;

import java.time.LocalDateTime;
public class SalesTransaction implements Comparable<SalesTransaction> {
        private int transactionId;
        private int salesPersonID;
        private LocalDateTime transactionDateTime;
        private int itemId;
        private double unitPrice;
        private int quantitySold;

        public static int DEFAULT_TRANSACTION_ID = 0;
        public static int DEFAULT_SALES_PERSON_ID = 0;
        public static  LocalDateTime DEFAULT_TRANSACTION_DATE_TIME = LocalDateTime.now();
        public static int DEFAULT_ITEM_ID = 0;
        public static double DEFAULT_UNIT_PRICE = 0;
        public static int DEFAULT_QUANTITY_SOLD = 0;

        public int getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(int transactionId) {
            transactionIdValidate(transactionId);
           this.transactionId = transactionId;
        }

        private void transactionIdValidate(int transactionId){
            if (transactionId <= 0){
                throw new IllegalArgumentException("The transactionId cannot be less than 0.");
            }
        }


        public int getSalesPersonID() {
            return salesPersonID;
        }

        public void setSalesPersonID(int salesPersonID)
        {
            validateSaleparsonId(salesPersonID);
            this.salesPersonID = salesPersonID;
        }
        private  void validateSaleparsonId(int salesPersonID ){
            if (salesPersonID < 0) {

                throw new IllegalArgumentException("salesPersonID cannot be less than 0.");
            }
    }

        public LocalDateTime getTransactionDateTime() {
            return transactionDateTime;
        }

        public void setTransactionDateTime(LocalDateTime transactionDateTime) {
            this.transactionDateTime = transactionDateTime;
        }

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {

            this.itemId = itemId;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public int getQuantitySold() {
            return quantitySold;
        }

        public void setQuantitySold(int quantitySold) {
            this.quantitySold = quantitySold;
        }

        @Override
        public int compareTo(SalesTransaction o) {
            return getTransactionDateTime().compareTo(o.getTransactionDateTime());
        }

        public SalesTransaction() {
            this (DEFAULT_TRANSACTION_ID,DEFAULT_SALES_PERSON_ID,DEFAULT_TRANSACTION_DATE_TIME,DEFAULT_ITEM_ID
                    , DEFAULT_UNIT_PRICE,DEFAULT_QUANTITY_SOLD);
        }

    public SalesTransaction(int transactionId, int salesPersonID, LocalDateTime transactionDateTime, int itemId,
                            double unitPrice, int quantitySold) {
            validateSaleparsonId(salesPersonID);
            transactionIdValidate(transactionId);

        this.transactionId = transactionId;
        this.salesPersonID = salesPersonID;
        this.transactionDateTime = transactionDateTime;
        this.itemId = itemId;
        this.unitPrice = unitPrice;
        this.quantitySold = quantitySold;
    }
}
