package gradleProject.shop3.mapper;

import gradleProject.shop3.domain.User;
import gradleProject.shop3.dto.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-07T17:41:53+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.2.jar, environment: Java 17.0.14 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserid( userDto.getUserid() );
        user.setChannel( userDto.getChannel() );
        user.setPassword( userDto.getPassword() );
        user.setUsername( userDto.getUsername() );
        user.setPhoneno( userDto.getPhoneno() );
        user.setPostcode( userDto.getPostcode() );
        user.setAddress( userDto.getAddress() );
        user.setEmail( userDto.getEmail() );
        user.setBirthday( userDto.getBirthday() );

        return user;
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserid( user.getUserid() );
        userDto.setChannel( user.getChannel() );
        userDto.setPassword( user.getPassword() );
        userDto.setUsername( user.getUsername() );
        userDto.setPhoneno( user.getPhoneno() );
        userDto.setPostcode( user.getPostcode() );
        userDto.setAddress( user.getAddress() );
        userDto.setEmail( user.getEmail() );
        userDto.setBirthday( user.getBirthday() );

        return userDto;
    }
}
