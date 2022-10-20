package pl.niepracuj.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import pl.niepracuj.model.dto.*;
import pl.niepracuj.model.dto.advertisement.AdvertisementDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementSearchCriteriaDto;
import pl.niepracuj.model.enums.SeniorityEnum;
import pl.niepracuj.model.enums.TechnologyEnum;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.niepracuj.util.TestUtils.toJson;

@SpringBootTest
@AutoConfigureMockMvc
@SqlGroup({
        @Sql(scripts = "/sql/controller/advertisement.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        @Sql(scripts = "/sql/controller/advertisement-cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
})
public class AdvertisementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenGetAllAdvertisements_thenReturnAdvertisements() throws Exception {
        //when && then
        mockMvc.perform(get("/adv/all")).andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", equalTo(3)));
    }

    @Test
    public void whenGetAdvertisementsByCompanyId_thenReturnCompanyAdvertisements() throws Exception {
        //when && then
        mockMvc.perform(get("/adv/all/company/{companyId}", "1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", equalTo(3)));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    public void shouldCreateNewAdvertisement() throws Exception {
        //given
        CompanyDto companyDto = new CompanyDto(1L,"Company Co", "Krucza 1 00-000 Miasto", "company.co@company.com", 250);
        SeniorityDto seniorityDto = new SeniorityDto(1L,SeniorityEnum.JUNIOR);
        TechnologyDto technologyDto = new TechnologyDto(1L,TechnologyEnum.JAVA);
        StateDto stateDto = new StateDto(2L, "DOLNOŚLĄSKIE");
        CityDto cityDto = new CityDto(1L,"Bolesławiec", stateDto);
        LevelDto levelDto = new LevelDto(1L,"INTERN", 1);

        Set<SkillDto> skills = Set.of(SkillDto.builder()
                        .level(levelDto)
                .name("Programming")
                .build());

        var advertisementDto = AdvertisementDto.builder()
                .id(4L)
                .name("Potrzebny Programista JAVA")
                .description("Opis")
                .company(companyDto)
                .expireDate(LocalDateTime.of(2022, 12, 29, 23, 0, 0))
                .salaryFrom(1000L)
                .salaryTo(2000L)
                .seniority(seniorityDto)
                .technology(technologyDto)
                .city(cityDto)
                .skills(skills)
                .build();

        var advertisementCreateDtoJson = toJson(advertisementDto);
        //when && then
        mockMvc.perform(post("/adv/create").content(advertisementCreateDtoJson)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk()).andExpect(jsonPath("$.description", equalTo("Opis")));
    }


    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    public void whenGetAdvertisementByCriteria_thenOkResponse() throws Exception {
        //given
        var criteria = AdvertisementSearchCriteriaDto.builder()
                .technologyName(TechnologyEnum.JAVA).build();
        var criteriaJson = toJson(criteria);

        //when && then
        mockMvc.perform(post("/adv/search").content(criteriaJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", equalTo(2)));
    }

    @ParameterizedTest
    @ArgumentsSource(CriteriaProvider.class)
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    public void whenGetAdvertisementByCriteriaParam_thenOkResponse(TechnologyEnum technology,
                                                                   String city,
                                                                   SeniorityEnum seniority,
                                                                   int result) throws Exception {
        //given
        var criteria = AdvertisementSearchCriteriaDto.builder()
                .technologyName(technology)
                .cityName(city)
                .seniorityName(seniority)
                .build();
        var criteriaJson = toJson(criteria);

        //when && then
        mockMvc.perform(post("/adv/search").content(criteriaJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", equalTo(result)));
    }

    static class CriteriaProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(TechnologyEnum.JAVA, null, null, 2),
                    Arguments.of(null, "Nowogrodziec", null, 1),
                    Arguments.of(null, null, SeniorityEnum.MID, 1)
            );
        }
    }
}
