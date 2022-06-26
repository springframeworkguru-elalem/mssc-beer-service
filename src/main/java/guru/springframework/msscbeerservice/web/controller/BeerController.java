package guru.springframework.msscbeerservice.web.controller;

import guru.springframework.msscbeerservice.services.BeerService;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import guru.springframework.msscbeerservice.web.model.BeerPagedList;
import guru.springframework.msscbeerservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by jt on 2019-05-12.
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    private final BeerService beerService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<BeerPagedList> listBeers(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                 @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                 @RequestParam(value = "beerName", required = false) String beerName,
                                                 @RequestParam(value = "beerStyle", required = false) BeerStyleEnum beerStyle,
                                                 @RequestParam(value = "showInventory", required = false, defaultValue = "false") Boolean showInventory) {
        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        return ResponseEntity.ok().body(beerService.listBeers(beerName, beerStyle, PageRequest.of(pageNumber, pageSize), showInventory));
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId, @RequestParam(value = "showInventory", defaultValue = "false", required = false) Boolean showInventory){
        return new ResponseEntity<>(beerService.getById(beerId, showInventory), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto){
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto){
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byupc/{beerUpc}")
    public ResponseEntity<BeerDto> getBeerByUpc(@PathVariable("beerUpc") String beerUpc, @RequestParam(value = "showInventory", defaultValue = "false", required = false) Boolean showInventory){
        return new ResponseEntity<>(beerService.getByUPC(beerUpc, showInventory), HttpStatus.OK);
    }
}
