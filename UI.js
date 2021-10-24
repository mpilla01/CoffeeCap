class UI {
    person;
    recs;
    constructor() {
        
    }

    // UI = {
    //     //set recs to a new recs object

    // }

    displayRecs() {
        let settings = document.getElementById("initial");
        settings.style.display = "none";
        
        //make sure to create getFirstRec and getSecondRec in recs.html
        if (this.recs.getFirstRec === null && this.recs.getSecondRec === null) {

        } else if (this.recs.getFirstRec === null) {

        } else if (this.recs.getSecondRec === null) {

        } else {

        }
    }

    inputValid(choice) {
        let index = ((choice - Math.round(choice)) * 10) - 1
        if (Math.round(choice) === 1) {
            while (!(index < this.recs.getFirstRec().size())) {
                //print
                //input
                this.inputValid(choice);
            }
        }
        if (Math.round(choice) === 2) {

        }
    }
}