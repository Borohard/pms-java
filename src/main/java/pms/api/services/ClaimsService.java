package pms.api.services;

import pms.api.exceptions.NoAccessException;
import pms.api.models.Claim;

import java.util.List;

public interface ClaimsService {
    Claim getById(Long id) throws NoAccessException;
    List<Claim> getAll();
    void add(Claim claim);
    void update(Claim claim) throws NoAccessException;
    void remove(Long claimId) throws NoAccessException;
}
