package com.msansar.wordmemorization.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class WordGroupServiceTest {


}
/*

    private WordGroupRepository wordGroupRepository;
    private WordGroupDtoConverter dtoConverter;
    private WordGroupService wordGroupService;

    @BeforeEach
    void setUp(){
        wordGroupRepository = mock(WordGroupRepository.class);
        dtoConverter = mock(WordGroupDtoConverter.class);
        wordGroupService = new WordGroupService(wordGroupRepository, userService, dtoConverter);
    }

    @Test
    public void testFindAll_shouldReturnUserDtoList(){
        WordGroup user1 = new WordGroup();
        WordGroup user2 = new WordGroup();

        when(wordGroupRepository.findAll()).thenReturn(List.of(user1, user2));
        when(dtoConverter.convertToDtoList(List.of(user1, user2))).thenReturn(
                List.of(
                        new WordGroupResponseDto("id1", "userId1", "foreign", "local", new Date(), new Date(), true),
                        new WordGroupResponseDto("id2", "userId2", "foreign", "local", new Date(), new Date(), true)
                )
        );
        assertEquals(2, wordGroupService.findAll().size());
    }


    @Test
    public void testFindById_whenIdExist_shouldReturnWordGroupResponseDto(String id){
        WordGroup wordGroup = new WordGroup("userId", "foreign", "local", true);
        WordGroupResponseDto responseDto = new WordGroupResponseDto(wordGroup.getId(),
                wordGroup.getUserId(),
                wordGroup.getForeignWord(),
                wordGroup.getLocalWord(),
                wordGroup.getCreatedAt(),
                wordGroup.getUpdatedAt(),
                wordGroup.isActive());

        when(wordGroupRepository.findById("id")).thenReturn(Optional.of(wordGroup));
        when(dtoConverter.convertToDto(wordGroup)).thenReturn(responseDto);
        when(wordGroupService.findById("id")).thenReturn(responseDto);

        assertEquals("foreign", wordGroupService.findById("id").getForeignWord());
    }
    @Test
    public void testFindById_whenIdDoesNotExist_throwReturnNotFoundException(String id){

    }
    @Test
    public void testDelete_whenIdExists_shouldDeleteWordGroup(){

    }
    @Test
    public void testDelete_whenIdDoesNotExists_shouldThrowCustomNotFoundException(){

    }
    @Test
    public void testSave_whenNewWordGroupIsSaved_ShouldReturnMessage(){

    }
    @Test
    public void testSave_whenUserIdDoesNotExist_ShouldThrowNotFoundException(){

    }
    @Test
    public void testUpdate_whenUpdatedWordGroup_ShouldReturnMessage(){

    }
    @Test
    public void testUpdate_whenWordGroupDoesNotExist_ShouldReturnNotFoundException(){

    }


 */
