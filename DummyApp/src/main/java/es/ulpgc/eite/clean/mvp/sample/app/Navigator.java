package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.detail.Detail;
import es.ulpgc.eite.clean.mvp.sample.dummy.Dummy;
import es.ulpgc.eite.clean.mvp.sample.filter.Filter;
import es.ulpgc.eite.clean.mvp.sample.main.Main;
import es.ulpgc.eite.clean.mvp.sample.master.Master;

public interface Navigator {
  void goToNextScreen(Dummy.DummyTo presenter);
  void goToFilterScreen(Main.MainToFilter presenter);
  void goToMainScreen(Filter.FilterToMain presenter);
  void backToMasterScreen(Detail.DetailToMaster presenter);
  void goToDetailScreen(Master.MasterToDetail presenter);


}
