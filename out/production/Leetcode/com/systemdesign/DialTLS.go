package main

import (
	"crypto/tls"
	"fmt"
	"net"
	"net/http"
	"time"
)

func main() {
	dialTLS := func(network, addr string) (net.Conn, error) {
		startTCP := time.Now()

		// setup TCP connection
		tcpConn, err := net.Dial(network, addr)
		if err != nil {
			return nil, err
		}
		fmt.Printf("TCP connection established in %v\n", time.Since(startTCP))

		config := &tls.Config{
			InsecureSkipVerify: true,
		}

		// setup TLS connection
		tlsConn := tls.Client(tcpConn, config)
		startTLS := time.Now()
		err = tlsConn.Handshake()
		if err != nil {
			return nil, err
		}
		fmt.Printf("TLS handshake completed in %v\n", time.Since(startTLS))
		fmt.Printf("TCP+TLS handshake used time  %v\n", time.Since(startTCP))
		fmt.Printf("TLS version: %v\n", tlsConn.ConnectionState().Version)
		return tlsConn, nil
	}

	//proxyURL, err := url2.Parse("http://127.0.0.1:7897")
	transport := &http.Transport{
		DialTLS: dialTLS,
		//Proxy:   http.ProxyURL(proxyURL),
	}

	client := &http.Client{
		Transport: transport,
		//CheckRedirect: func(req *http.Request, via []*http.Request) error {
		//	return http.ErrUseLastResponse
		//},
	}

	url := "https://www.entirelyfuck.co.uk"
	start := time.Now()
	response, err := client.Get(url)
	if err != nil {
		fmt.Printf("Error: %v\n", err)
		return
	}

	defer response.Body.Close()
	fmt.Printf("Total request time: %v\n", time.Since(start))
	fmt.Printf("Response status: %s\n", response.Status)
	fmt.Printf("HTTP version: %d.%d\n", response.ProtoMajor, response.ProtoMinor)
}
