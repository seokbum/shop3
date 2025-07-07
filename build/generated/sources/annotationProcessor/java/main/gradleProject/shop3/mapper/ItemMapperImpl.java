package gradleProject.shop3.mapper;

import gradleProject.shop3.domain.Item;
import gradleProject.shop3.dto.ItemDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-27T15:36:20+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.2.jar, environment: Java 17.0.14 (Eclipse Adoptium)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item toEntity(ItemDto ItemDto) {
        if ( ItemDto == null ) {
            return null;
        }

        Item item = new Item();

        item.setId( ItemDto.getId() );
        item.setName( ItemDto.getName() );
        item.setPrice( ItemDto.getPrice() );
        item.setDescription( ItemDto.getDescription() );
        item.setPictureUrl( ItemDto.getPictureUrl() );
        item.setPicture( ItemDto.getPicture() );

        return item;
    }

    @Override
    public ItemDto toDto(Item Item) {
        if ( Item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setId( Item.getId() );
        itemDto.setName( Item.getName() );
        itemDto.setPrice( Item.getPrice() );
        itemDto.setDescription( Item.getDescription() );
        itemDto.setPictureUrl( Item.getPictureUrl() );
        itemDto.setPicture( Item.getPicture() );

        return itemDto;
    }
}
