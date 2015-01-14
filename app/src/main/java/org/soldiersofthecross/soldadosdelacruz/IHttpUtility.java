package org.soldiersofthecross.soldadosdelacruz;

import com.loopj.android.http.RequestParams;

/**
 * Created by victordiaz on 1/8/15.
 */
public interface IHttpUtility {

    public void getEndpoint(String endpoint);

    public void postEndpoint(String endpoint, RequestParams params);

    public void putEndpoint(String endpoint, RequestParams params);

    public void deleteEndpoint(String endpoint);
}
