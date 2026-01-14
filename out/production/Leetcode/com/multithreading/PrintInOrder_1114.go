package multithreading

import (
	"fmt"
	"sync"
)

type Foo struct {
	ch1 chan struct{}
	ch2 chan struct{}
}

func NewFoo() *Foo {
	return &Foo{
		ch1: make(chan struct{}),
		ch2: make(chan struct{}),
	}
}

func (f *Foo) First(printFirst func()) {
	printFirst()

	close(f.ch1)
}

func (f *Foo) Second(printSecond func()) {
	<-f.ch1
	printSecond()
	close(f.ch2)
}

func (f *Foo) Third(printThird func()) {
	<-f.ch2
	printThird()
}

func main() {
	f := NewFoo()
	wg := sync.WaitGroup{}
	wg.Add(3)

	go func() {
		defer wg.Done()
		f.First(func() {
			fmt.Print("first")
		})
	}()

	go func() {
		defer wg.Done()
		f.Second(func() {
			fmt.Print("Second")
		})
	}()

	go func() {
		defer wg.Done()
		f.Third(func() {
			fmt.Print("Third")
		})
	}()

	wg.Wait()
}
