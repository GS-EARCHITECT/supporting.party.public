package party_class_details.service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import party_class_details.model.dto.PartyClassDetail_DTO;

public interface I_PartyClassDetails_Service
{
    public CompletableFuture<CopyOnWriteArrayList<PartyClassDetail_DTO>> getAllPartyClassDetails();
    public CompletableFuture<CopyOnWriteArrayList<PartyClassDetail_DTO>> getSelectPartyClassDetails(ArrayList<Long> ids);
    public CompletableFuture<CopyOnWriteArrayList<PartyClassDetail_DTO>> getSelectPartiesForClasses(ArrayList<Long> ids);   
       
}