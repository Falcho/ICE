package Controllers;

import Models.CharacterSheet;
import Views.CreateBackgroundView;

public class CreateBackgroundController implements RmController {

   private final CreateBackgroundView view;
   private final CharacterSheet model;

   public CreateBackgroundController(CreateBackgroundView view,CharacterSheet model){
       this.view= view;
       this.model=model;
   }

   private boolean validate(){
       return !view.getWrittenBackground().isEmpty();
   }

   private void saveDataToModel(String data){
       model.setBackground(data);
   }


   public boolean validateAndSave(){
       String data= view.getWrittenBackground();
       if(validate()){
           saveDataToModel(data);
           return true;
       }
       return false;
   }

}
