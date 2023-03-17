package com.curso.clientrest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.clientrest.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public ClienteServiceImpl(RestTemplate theRestTemplate,
			@Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		logger.info("Loaded property: crm.rest.url="+ crmRestUrl);
	}

	@Override
	public List<Cliente> getClientes() {

		logger.info("in getClientes(): Calling REST API "+ crmRestUrl);

		// make REST call

		ResponseEntity<List<Cliente>> responseEntity =
				restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Cliente>>() {});

		// get the list of customers from response

		List<Cliente> clientes = responseEntity.getBody();

		logger.info("in getClientes(): clientes" + clientes);

		return clientes;	
	
	}

	@Override
	public void guardarCliente(Cliente elCliente) {

		logger.info("in guardarCliente(): Calling REST API " + crmRestUrl);

		int employeeId = elCliente.getId();

		if (employeeId == 0) {//si no hay id
			// hace un post
			restTemplate.postForEntity(crmRestUrl, elCliente, String.class);
		} else { // si hay id
			// hace actualización
			restTemplate.put(crmRestUrl, elCliente);
		}

		logger.info("in guardarCliente(): success");
	}

	@Override
	public Cliente getCliente(int theId) {

		logger.info("in getCliente(): Calling REST API " + crmRestUrl);

		//va por el cliente con el id
		Cliente elCliente = restTemplate.getForObject(crmRestUrl + "/" + theId, Cliente.class);

		logger.info("in guardarCliente(): elCliente=" + elCliente);

		//regresamos el cliente
		return elCliente;
	}

	@Override
	public void eliminarCliente(int theId) {

		logger.info("in eliminarCliente(): Calling REST API " + crmRestUrl);

		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in eliminarCliente(): deleted cliente theId="+ theId);
	}
	
}
