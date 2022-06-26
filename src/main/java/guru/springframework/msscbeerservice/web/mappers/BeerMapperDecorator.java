package guru.springframework.msscbeerservice.web.mappers;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.services.inventory.BeerInventoryService;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

// MapStruct may cause issues with ConstructorInjection
//@RequiredArgsConstructor
@Slf4j
@Setter
public abstract class BeerMapperDecorator implements BeerMapper {
    @Autowired
    private BeerInventoryService beerInventoryService;
    @Autowired
    private BeerMapper mapper;

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        return mapper.beerToBeerDto(beer);
    }

    @Override
    public BeerDto beerToBeerDtoWithInventory(Beer beer) {
        BeerDto beerDto = beerToBeerDto(beer);
        beerDto.setQuantityOnHand(beerInventoryService.getOnHandBeerInventory(beer.getId()));

        log.info("After populating quantityOnHand {}", beerDto);

        return beerDto;
    }
}
