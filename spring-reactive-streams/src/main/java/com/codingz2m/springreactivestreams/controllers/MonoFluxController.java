package com.codingz2m.springreactivestreams.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mono-flux")
public class MonoFluxController {
	 
	 // Mono
	 @GetMapping(path ="/headphone")
		public void productsMono() {   // Relaxing the restrictions on a variable using wildcard
			
			Mono<?> mono =  Mono.just(     // Publisher
					"ZEBRONICS Zeb-Thunder Wireless BT Headphone Comes with 40mm Drivers, AUX Connectivity, Built in FM, Call Function"
					)
					//.then(Mono.error(new RuntimeException("Exception Occured")))
					.log();
			
			mono.subscribe( (product)-> {   //  Subscriber
											System.out.println(product);
									    }
						//	(error)-> {   //  Subscriber
										//	System.out.println(error);
									//	}
			               );
		}
	 
	 
	//Flux 
	 @GetMapping(path ="/television")
		public void productsFlux() {
			
			Flux<String> flux =  Flux.just(     // Publisher
					"Sony Bravia 189 cm (75 inches) XR Series 4K Ultra HD Smart Full Array LED Google TV XR-75X90K",
					"Sony Bravia 164 cm (65 inches) XR Series 4K Ultra HD Smart OLED Google TV XR-65A80K",
					"Sony Bravia 164 cm (65 inches) XR Series 4K Ultra HD Smart OLED Google TV XR-65A95K"
					)
					//.concatWith(Flux.error(new RuntimeException("Exception Occured")))
					.concatWithValues("Sony SLR Camera SL8700C")
					.log();
			
			flux.subscribe( (product)-> {   //  Subscriber
											System.out.println(product);
									    },
							(error)-> {   //  Subscriber
											System.out.println(error);
									  }
						  );
			
		}
	 
	 
}
