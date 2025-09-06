package com.Library.student_library_management.requestDTO;

import com.Library.student_library_management.enums.CardStatus;


public class CardRequestDTO {

    private CardStatus cardStatus;
    private String bloodGroup;
    private int studentId;

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
