package com.msa.BookMS.domin.model.event;

import lombok.Getter;


@Getter
public class ItemReturned extends ItemRented{

    public ItemReturned(IDName idName, Item item, long point) {
        super(idName, item, point);
    }
}
