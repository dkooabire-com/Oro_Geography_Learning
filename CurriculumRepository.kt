package com.oro.geography.data

data class UnitInfo(val id: String, val grade: Int, val unitNumber: Int, val title: String, val description: String, val notes: String)
data class Question(val question: String, val options: List<String>, val correctAnswer: Int, val explanation: String)

object CurriculumRepository {
    val units = listOf(
        UnitInfo("g9u1",9,1,"Introduction to Geography","Concept, scope, branches and location of Ethiopia",
            "• Geography studies places, environments and relationships between people and their surroundings.\n\n• Physical geography examines landforms, climate, water and vegetation.\n\n• Human geography examines population, settlement, economic activities and culture.\n\n• Ethiopia is located in the northeastern part of Africa, within the Horn of Africa.\n\n• Absolute location is described using latitude and longitude; relative location describes a place in relation to other places."),
        UnitInfo("g9u2",9,2,"The Earth and Its Landforms","Internal and external processes",
            "• Internal processes include folding, faulting, earthquakes and volcanism.\n\n• External processes include weathering, erosion, transportation and deposition.\n\n• Weathering breaks rocks down in place. Erosion removes and transports material.\n\n• Landforms include mountains, plateaus, plains, valleys and basins."),
        UnitInfo("g10u1",10,1,"Africa: Location and Major Landforms","Continents, plateaus, mountains, basins and rift valleys",
            "• Africa is crossed by the Equator and extends into both the Northern and Southern Hemispheres.\n\n• The Atlas Mountains lie in northwestern Africa.\n\n• The Sahara is the world's largest hot desert.\n\n• The East African Rift Valley formed mainly through tensional forces and normal faulting.\n\n• The savanna is a tropical grassland with scattered trees and seasonal rainfall."),
        UnitInfo("g10u2",10,2,"Climate of Africa","Climate controls and major climate regions",
            "• Latitude affects the angle and intensity of incoming solar radiation.\n\n• Altitude, distance from the sea, ocean currents, relief and prevailing winds also influence climate.\n\n• Equatorial regions are generally hot and wet; deserts are very dry; Mediterranean regions have dry summers and wetter winters."),
        UnitInfo("g11u1",11,1,"Continents and Oceans","Earth history and changing continental positions",
            "• The Big Bang model explains the expansion of the universe.\n\n• Earth formed about 4.5 billion years ago.\n\n• Continental drift proposes that continents have changed position over geological time.\n\n• Pangaea was a supercontinent that later fragmented into separate landmasses.\n\n• Evidence for continental drift includes matching coastlines, fossils, rock formations and past-climate indicators."),
        UnitInfo("g11u2",11,2,"Weather and Climate","Climate elements and classification",
            "• Weather describes short-term atmospheric conditions; climate describes long-term patterns.\n\n• Main elements include temperature, precipitation, humidity, wind, air pressure and cloud cover.\n\n• Köppen climate classification uses temperature and precipitation patterns linked to vegetation.\n\n• Climate zones are modified by latitude, altitude, relief, ocean currents and distance from oceans."),
        UnitInfo("g12u1",12,1,"Geological Processes and Plate Tectonics","Plate boundaries, earthquakes and volcanoes",
            "• Lithospheric plates move over the more deformable upper mantle.\n\n• Divergent boundaries move apart; convergent boundaries move together; transform boundaries slide past one another.\n\n• Earthquakes result from sudden energy release, commonly along faults.\n\n• Volcanoes occur where magma reaches the surface, often near plate boundaries or hotspots.\n\n• The East African Rift is an important continental rift system."),
        UnitInfo("g12u2",12,2,"Population and Development","Population distribution and human-environment relationships",
            "• Population distribution is uneven because of physical, economic, historical and social factors.\n\n• Population density is calculated by dividing population by land area.\n\n• Sustainable development seeks to meet present needs without compromising future generations.")
    )
    val questions = listOf(
        Question("Which branch of geography studies landforms and climate?", listOf("Human geography","Physical geography","Economic geography","Political geography"),1,"Physical geography studies natural features and processes."),
        Question("What is the removal and transport of weathered material called?", listOf("Deposition","Condensation","Erosion","Folding"),2,"Erosion removes and transports material."),
        Question("Which mountain range is in northwestern Africa?", listOf("Atlas Mountains","Drakensberg","Alps","Himalayas"),0,"The Atlas Mountains extend across northwestern Africa."),
        Question("Which force commonly forms normal faults in a rift valley?", listOf("Compression","Tension","Magnetism","Condensation"),1,"Tensional forces pull the crust apart."),
        Question("Earth formed approximately how long ago?", listOf("450 million years","4.5 billion years","45 billion years","10,000 years"),1,"Earth formed about 4.5 billion years ago."),
        Question("Which climate classification is widely associated with temperature and precipitation thresholds?", listOf("Köppen","Mercator","Wegener scale","Richter"),0,"Köppen classification groups climates using temperature and precipitation."),
        Question("At a divergent plate boundary, plates move:", listOf("Toward each other","Apart from each other","Only vertically","Without movement"),1,"Divergent boundaries are zones where plates move apart."),
        Question("Population density is calculated as:", listOf("Area ÷ population","Population ÷ area","Births ÷ deaths","Rainfall ÷ temperature"),1,"Population density equals population divided by land area.")
    )
    fun getUnitsForGrade(grade: Int) = units.filter { it.grade == grade }
    fun getUnit(id: String) = units.firstOrNull { it.id == id }
}
