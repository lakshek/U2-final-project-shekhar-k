// import images used in the ExplorePage
import BabyInCrib from '../assets/BabyInCrib.jpg'
import BabyWithPacifier from '../assets/BabyWithPacifier.jpg'

// import long texts as variables 
import { babyInCribDesc, babyWithPacifier } from './texts'

export const topics = [
    {
        id: 1,
        name: "Trade the Crib for Curiosity",
        desc: babyInCribDesc,
        img: BabyInCrib
    },
    {
        id: 2,
        name: "Set the Pacifier Aside, Listen and Respond",
        desc: babyWithPacifier,
        img: BabyWithPacifier
    }
]