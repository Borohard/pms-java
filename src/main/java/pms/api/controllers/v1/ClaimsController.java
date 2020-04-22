package pms.api.controllers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pms.api.dto.ClaimDto;
import pms.api.exceptions.NoAccessException;
import pms.api.mappers.ClaimMapper;
import pms.api.models.Claim;
import pms.api.services.ClaimsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/claims")
public class ClaimsController {
    private final ClaimMapper mapper;
    private final ClaimsService claims;

    @Autowired
    public ClaimsController(ClaimMapper mapper, ClaimsService claims){
        this.claims = claims;
        this.mapper = mapper;
    }

    @GetMapping("")
    public ResponseEntity getAll(){
        List<Claim> dbClaims = claims.getAll();
        List<ClaimDto> response = dbClaims
                .stream()
                .map(mapper::toDtoFromClaim)
                .collect(Collectors.toList());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            Claim dbClaim = claims.getById(id);
            return new ResponseEntity(mapper.toDtoFromClaim(dbClaim), HttpStatus.OK);
        } catch (NoAccessException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("")
    public ResponseEntity add(@RequestBody ClaimDto claimDto){
        claims.add(mapper.toClaimFromDto(claimDto));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody ClaimDto claimDto){
        try {
            claims.update(mapper.toClaimFromDto(claimDto));
            return new ResponseEntity(HttpStatus.OK);
        } catch (NoAccessException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            claims.remove(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (NoAccessException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
