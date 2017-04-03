package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.dummy.Dummy;
import es.ulpgc.eite.clean.mvp.sample.main.Main;

public interface Navigator {
  void goToNextScreen(Dummy.DummyTo presenter);
  void goToFilterScreen(Main.MainToFilter presenter);
  void goToMainScreen(Filter.FilterToMain presenter);


}
