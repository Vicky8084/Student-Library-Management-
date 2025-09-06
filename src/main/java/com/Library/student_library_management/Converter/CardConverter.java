package com.Library.student_library_management.Converter;

import com.Library.student_library_management.model.Card;
import com.Library.student_library_management.requestDTO.CardRequestDTO;

public class CardConverter {
    public static Card convertCardRequestDtoIntoCard(CardRequestDTO cardRequestDTO){
        Card card=new Card();
        card.setCardStatus(cardRequestDTO.getCardStatus());
        card.setBloodGroup(cardRequestDTO.getBloodGroup());
        return card;
    }
}
