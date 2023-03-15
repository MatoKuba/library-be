package sk.umb.example.library.category.service;

import jakarta.transaction.Transactional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import sk.umb.example.library.address.persistence.entity.AddressEntity;
import sk.umb.example.library.address.persistence.repository.AddressRepository;
import sk.umb.example.library.address.service.AddressDetailDto;
import sk.umb.example.library.book.persistence.entity.BookEntity;
import sk.umb.example.library.book.persistence.repository.BookRepository;
import sk.umb.example.library.book.service.BookDetailDTO;
import sk.umb.example.library.book.service.BookRequestDTO;
import sk.umb.example.library.category.persistence.entity.CategoryEntity;
import sk.umb.example.library.category.persistence.repository.CategoryRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final AddressRepository addressRepository;

    public CategoryService(CategoryRepository categoryRepository,
                       AddressRepository addressRepository) {
        this.categoryRepository = categoryRepository;
        this.addressRepository = addressRepository;
    }
    private final AtomicLong lastIndex = new AtomicLong(0);

    private final Map<Long, CategoryDetailDTO> categoryDatabase = new HashMap();

    public List<CategoryDetailDTO> getAllCategories() {
        return mapToDtoList(categoryRepository.findAll());
    }

    public List<CategoryDetailDTO> searchCategoryByName(String name) {
        return mapToDtoList(categoryRepository.findCategoryByName(name));
    }

    public CategoryDetailDTO getCategoryById(Long categoryId) {
        return mapToDto(getCategoryEntityById(categoryId));
    }

    @Transactional
    public Long createCategory(CategoryRequestDTO categoryRequestDTO) {
        CategoryEntity entity = mapToEntity(categoryRequestDTO);

        return categoryRepository.save(entity).getId();
    }

    @Transactional
    public void updateCategory(Long categoryId, CategoryRequestDTO categoryRequestDTO) {
        CategoryEntity category = getCategoryEntityById(categoryId);

        if (! Strings.isEmpty(categoryRequestDTO.getName())) {
            category.setName(categoryRequestDTO.getName());
        }

        categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
    private CategoryDetailDTO mapToDto(CategoryEntity categoryEntity) {
        CategoryDetailDTO dto = new CategoryDetailDTO();
        dto.setId(categoryEntity.getId());
        dto.setName(categoryEntity.getName());

        return dto;
    }
    private CategoryEntity getCategoryEntityById(Long categoryId) {
        Optional<CategoryEntity> category = categoryRepository.findById(categoryId);

        if (category.isEmpty()) {
            throw new IllegalArgumentException("category not found. ID: " + categoryId);
        }

        return category.get();
    }

    private CategoryEntity mapToEntity(CategoryRequestDTO dto) {
        CategoryEntity category = new CategoryEntity();

        if ( ! Objects.isNull(dto.getAddressId()) ) {
            Optional<AddressEntity> address = addressRepository.findById(dto.getAddressId());

            if (address.isPresent()) {
                category.setAddress(address.get());
            }
        }

        category.setName(dto.getName());

        return category;
    }

    private List<CategoryDetailDTO> mapToDtoList(Iterable<CategoryEntity> categoryEntities) {
        List<CategoryDetailDTO> categories = new ArrayList<>();

        categoryEntities.forEach(categoryEntity -> {
            CategoryDetailDTO dto = mapToDto(categoryEntity);
            categories.add(dto);
        });

        return categories;
    }

    private CategoryDetailDTO mapToCategoryDetailDTO(CategoryEntity categoryEntity) {
        CategoryDetailDTO dto = new CategoryDetailDTO();
        dto.setId(categoryEntity.getId());
        dto.setName(categoryEntity.getName());

        return dto;
    }

    private AddressDetailDto mapToDto(AddressEntity addressEntity) {
        AddressDetailDto dto = new AddressDetailDto();
        dto.setId(addressEntity.getId());
        dto.setCity(addressEntity.getCity());

        return dto;
    }
}