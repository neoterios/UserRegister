package portfolio.com.gestion.mappers;

import org.mapstruct.Mapper;
import portfolio.com.gestion.dtos.PhonePostDto;
import portfolio.com.gestion.dtos.UserGetDto;
import portfolio.com.gestion.dtos.UserPostDto;
import portfolio.com.gestion.model.Phone;
import portfolio.com.gestion.model.User;

@Mapper(
        componentModel = "spring"
)
public interface PortfolioMapper {

    User userPostDtoToUser(UserPostDto userPostDto);
    Phone phonePostDtoToTelefono(PhonePostDto phonePostDto);
    UserGetDto userToUserGetDto(User user);

}
