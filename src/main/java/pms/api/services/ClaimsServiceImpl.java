package pms.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pms.api.exceptions.NoAccessException;
import pms.api.models.Claim;
import pms.api.models.User;
import pms.api.repositories.ClaimPositionsRepository;
import pms.api.repositories.ClaimsRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClaimsServiceImpl implements ClaimsService {
    private final ClaimsRepository claims;
    private final UserService users;
    private final ClaimPositionsRepository positions;

    @Autowired
    public ClaimsServiceImpl(ClaimsRepository claims, UserService users, ClaimPositionsRepository positions) {
        this.claims = claims;
        this.users = users;
        this.positions = positions;
    }

    @Override
    public Claim getById(Long id) throws NoAccessException{
        Claim responseClaim = claims.findOne(id);
        User currentUser = users.getCurrentUser();

        if (isUserHasAccessToClaim(responseClaim, currentUser)){
            return responseClaim;
        }

        throw new NoAccessException
                ("User " + currentUser.getLogin() + " doesn't have access to claim " + responseClaim.getId());
    }

    private boolean isUserHasAccessToClaim(Claim responseClaim, User currentUser) {
        return users.isCurrentUserAdmin()
                || responseClaim.getUser().getId().longValue() == currentUser.getId().longValue()
                || isClaimAttachedToUserDepartment(responseClaim, currentUser);
    }

    private Boolean isClaimAttachedToUserDepartment(Claim claim , User currentUser){
        return (currentUser.getDepartments() != null &&
                currentUser
                        .getDepartments()
                        .stream()
                        .anyMatch(department -> department
                                .getUsers()
                                .stream()
                                .map(User::getId)
                                .anyMatch(id -> id.longValue() == claim.getUser().getId().longValue()))); // TODO: очень страшно, разобраться с Equals в user
    }

    @Override
    public List<Claim> getAll(){
        if (users.isCurrentUserAdmin())
            return claims.findAll();

        User currentUser = users.getCurrentUser();
        ArrayList<Claim> claims = new ArrayList(currentUser.getClaims());

        if (currentUser.getDepartments() != null) {
            currentUser.getDepartments().forEach(department -> {
                department.getUsers().forEach(departmentUser -> {
                    claims.addAll(departmentUser.getClaims());
                });
            });
        }

        return claims;
    }

    @Override
    public void add(Claim claim) {
        claims.save(claim);
        positions.save(claim.getClaimPositions());
    }

    @Override
    public void update(Claim claim) throws NoAccessException {
        User currentUser = users.getCurrentUser();

        if (isUserHasAccessToClaim(claim, currentUser)){
            claims.save(claim);
            positions.save(claim.getClaimPositions());
            return;
        }

        throw new NoAccessException
                ("User " + currentUser.getLogin() + " doesn't have access to claim " + claim.getId());
    }

    @Override
    public void remove(Long claimId) throws NoAccessException {
        Claim claimToRemove = claims.findOne(claimId);
        User currentUser = users.getCurrentUser();

        if (isUserHasAccessToClaim(claimToRemove, currentUser)) {
            positions.delete(claimToRemove.getClaimPositions());
            claims.delete(claimToRemove);
            return;
        }

        throw new NoAccessException
                ("User " + currentUser.getLogin() + " doesn't have access to claim " + claimToRemove.getId());
    }
}
