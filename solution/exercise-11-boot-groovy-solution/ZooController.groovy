@Grab("thymeleaf-spring4")
@Controller
public class ZooController {
    @Autowired private AnimalRepository animalRepository

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        return "redirect:" + fromMappingName("ZC#listAnimals").build()
    }

    @RequestMapping(value="animals", method = RequestMethod.GET)
    public String listAnimals(Map<String, Object> model) {
        model.putAll([animals: animalRepository.findAll()])
        "zoo";
    }

    @RequestMapping(value="animal", method = RequestMethod.POST)
    public String createAnimal(Animal animal) {
        animalRepository.create(animal)
        "redirect:" + fromMappingName("ZC#listAnimals").build()
    }

    @RequestMapping(value="animal/{id}/remove", method = RequestMethod.GET)
    public String removeAnimal(@PathVariable("id") int id) {
        animalRepository.remove(id)
        "redirect:" + fromMappingName("ZC#listAnimals").build()
    }
}
