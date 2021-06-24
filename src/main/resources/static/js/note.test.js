
import { mount } from '@vue/test-utils'
import note from './note.js';
global.axios = {
    get() { return Promise.resolve({ data: {id:249,date:"2021-06-22",headline:"test2",text:"test2",emotion:2,owner:"engemann.dominik@gmail.com"}}) },
    post() { return Promise.resolve('value') }
}

test('shows greeting',  async () =>  {
    const wrapper = mount(note);
    await wrapper.find('button');

    expect(wrapper.text()).toContain('bla')
})


